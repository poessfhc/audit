package com.edu.audit.business.service.impl;

import com.edu.audit.business.service.TrackService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TrackServiceImpl
 * @Description: TODO
 * @Author: Vince
 * @Date: 2020/5/12 21:01
 * @Version: v1.0
 */
@Service
public class TrackServiceImpl implements TrackService {
    @Override
    public void queryTrack() {
        //设施名
        List<String> installations = new ArrayList<>();
        //[
        // {value: ,
        //  name: ""
        // },
        //
        // ]
        //value:num
        //name: installation
        List<Object> objects = new ArrayList<>();

    }
}
