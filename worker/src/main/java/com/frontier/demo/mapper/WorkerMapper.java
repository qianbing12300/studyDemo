package com.frontier.demo.mapper;

import com.frontier.demo.controller.param.QueryWorkerRequest;
import com.frontier.demo.controller.param.SaveWorkerRequest;
import com.frontier.demo.domain.Worker;

import java.util.List;

/**
 * @author bing-qian
 *
 * @description: worker mapper处理层
 */
public interface WorkerMapper {

    /**
     * 保存工人对象
     *
     * @param saveWorkerRequest
     * @return 返回成功或失败
     */
     Integer saveWorker(SaveWorkerRequest saveWorkerRequest);

    /**
     * 修改工人信息
     *
     * @param worker
     * @return 返回成功或失败
     */
//    boolean updateWorker(Worker worker);

    /**
     * 根据id查询工人信息
     *
     * @param id
     * @return 工人对象
     */
    Worker getWorker(Long id);

    /**
     * 查询工人list
     *
     * @param queryWorkerRequest
     * @return 工人集合
     */
    List<Worker> listWorkers(QueryWorkerRequest queryWorkerRequest);

    /**
     * 根据id删除工人信息
     *
     * @param id
     * @return 返回成功或失败
     */
    boolean deleteWorker(Long id);
}
