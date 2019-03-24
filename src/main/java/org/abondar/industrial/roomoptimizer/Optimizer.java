package org.abondar.industrial.roomoptimizer;

import org.abondar.industrial.roomoptimizer.model.Allocation;
import org.abondar.industrial.roomoptimizer.model.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Optimizer {



    public List<Allocation> optimize(Resource res){
        List<Allocation> allocs = new ArrayList<>();

        if (res.getRooms().size()>100){
            return new ArrayList<>();
        }

        res.getRooms().forEach(r-> allocs.add(optimizeSingleRoom(r,res.getSenior(),res.getJunior())));
        return allocs;
    }


    private Allocation optimizeSingleRoom(int capacity,int senior,int junior){
        int seniorAlloc = capacity/senior;
        int juniorAlloc = 0;
        int currCapacity= senior*seniorAlloc;
        double overflowRate = 1.2;
        double currRate;

        while (true){

            currRate = calcCurrRate(currCapacity,capacity);
            if (currRate>=1){
                if (currRate<overflowRate){
                    break;
                } else {
                    currCapacity = currCapacity - senior + junior;

                    if (seniorAlloc>1){
                        seniorAlloc -=1;
                    }

                    juniorAlloc +=1;
                }
            } else {
                if (junior>=capacity-currCapacity){
                    currCapacity = currCapacity + junior;
                    juniorAlloc +=1;
                } else {
                    currCapacity = currCapacity + senior;
                    seniorAlloc +=1;
                }
            }
        }

        return new Allocation(seniorAlloc,juniorAlloc);
    }


    private double calcCurrRate(int currCapacity,int capacity){
        return (double) currCapacity / capacity;
    }
}
