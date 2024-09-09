package com.example.food.Service.Service;

import com.example.food.Service.IService.ICaculatePointsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CaculatePointsService implements ICaculatePointsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaculatePointsService.class);

    @Override
    public void caculatePoints() {
        LOGGER.info("TODO SOMETHINGS");
    }
}
