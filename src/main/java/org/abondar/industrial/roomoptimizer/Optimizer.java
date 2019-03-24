package org.abondar.industrial.roomoptimizer;

import org.abondar.industrial.roomoptimizer.model.Allocation;
import org.abondar.industrial.roomoptimizer.model.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Optimizer {

    public List<Allocation> optimize(Resource res){

        return new ArrayList<>();
    }
}
