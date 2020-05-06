package com.frontier.demo.service.impl;

import com.frontier.demo.constant.NumberConstant;
import com.frontier.demo.controller.param.QueryWorkerRequest;
import com.frontier.demo.controller.param.SaveWorkerRequest;
import com.frontier.demo.domain.Worker;
import com.frontier.demo.mapper.WorkerMapper;
import com.frontier.demo.service.WorkerService;
import com.frontier.demo.util.OperationEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bing-qian
 *
 * @descirption 工人业务service层实现类
 */
@Service
public class WorkerServiceImpl implements WorkerService {

    @Resource(name="workerMapper")
    private WorkerMapper workerMapper;

    @Override
    public OperationEnum saveWorker(SaveWorkerRequest saveWorkerRequest) {
        return workerMapper.saveWorker(saveWorkerRequest) == NumberConstant.NUMBER_ONE ?
                OperationEnum.ADD_SUCCESS : null;
    }

    /*@Override
    public boolean updateWorker(Worker worker) {
        return workerMapper.updateWorker(worker);
    }*/

    @Override
    public Worker getWorker(Long id) {
        Worker worker = workerMapper.getWorker(id);
        if (worker == null){
            return new Worker();
        }
        return worker;
    }

    @Override
    public List<Worker> listWorkers(QueryWorkerRequest queryWorkerRequest) {
        return workerMapper.listWorkers(queryWorkerRequest);
    }

    @Override
    public boolean deleteWorker(Long id) {
        return workerMapper.deleteWorker(id);
    }
}
