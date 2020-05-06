package com.frontier.demo.controller;

import com.frontier.demo.controller.param.QueryWorkerRequest;
import com.frontier.demo.controller.param.SaveWorkerRequest;
import com.frontier.demo.domain.Worker;
import com.frontier.demo.service.WorkerService;
import com.frontier.demo.util.OperationEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("worker")
@CrossOrigin
public class WorkerController {
    /**
     * 员工服务对象
     */
    @Autowired
    private WorkerService workerService;

    /**
     * 新增员工对象
     *
     * @param saveWorkerRequest
     * @return 返回成功或失败
     */
    @PostMapping("saveWorker")
    public OperationEnum saveWorker(@Valid @RequestBody SaveWorkerRequest saveWorkerRequest){
        return workerService.saveWorker(saveWorkerRequest);
    }

    /**
     * 查询单个员工对象
     *
     * @param id
     * @return 返回员工对象
     */
    @GetMapping("queryWorker")
    public Worker queryWorker(@RequestParam Long id){
        return workerService.getWorker(id);
    }

    /**
     * 查询员工对象列表
     *
     * @param queryWorkerRequest
     * @return 返回员工对象列表
     */
    @PostMapping("queryWorkerList")
    public List<Worker> queryWorkerList(@RequestBody QueryWorkerRequest queryWorkerRequest){
        return workerService.listWorkers(queryWorkerRequest);
    }

    /**
     * 查询单个员工对象
     *
     * @param id
     * @return 返回员工对象
     */
    @GetMapping("deleteWorker")
    public boolean deleteWorker(@RequestParam  Long id){
        return workerService.deleteWorker(id);
    }

    /**
     * 查询员工列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("queryPageWorkers")
    public PageInfo queryPageWorkers(@RequestParam int page, @RequestParam int pageSize){
        PageHelper.startPage(page,pageSize);
        List<Worker> workers = workerService.listWorkers(new QueryWorkerRequest());
        return new PageInfo(workers);
    }



}
