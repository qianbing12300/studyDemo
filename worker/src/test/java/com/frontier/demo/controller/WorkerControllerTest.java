package com.frontier.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WorkerControllerTest {

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    /**
     * 新增员工
     *
     * @throws Exception 异常
     */
    @Test
    public void testSaveUser() throws Exception {
        String content =
                "{\"name\":\"sn\",\"age\":12,\"birthday\":\"1991-01-07\"}";
        String result = mockMvc
                .perform(MockMvcRequestBuilders.post("/worker/saveWorker").contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(content))
                /*.andExpect(MockMvcResultMatchers.status().isOk())*/.andReturn().getResponse().getContentAsString();
        System.out.println("新增员工:" + result);
    }

    /**
     * 查询单个员工
     *
     * @throws Exception 异常
     */
    @Test
    public void testQueryWorker() throws Exception {
        String result =
                mockMvc.perform(MockMvcRequestBuilders.get("/worker/queryWorker?id=" + 1).contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("查询单个员工:" + result);
    }

    /**
     * 查询单个员工
     *
     * @throws Exception 异常
     */
    @Test
    public void testQueryWorkerList() throws Exception {
        String content = "{\"name\":\"\"}";
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/worker/queryWorkerList").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println("查询多个员工:" + result);
    }

    /**
     * 查询分页列表
     *
     * @throws Exception 异常
     */
    @Test
    public void testQueryPageWorkers() throws Exception {
        String content = "{\"page\":\"1\", \"pageSize\":\"10\"}";
        String result =
                mockMvc.perform(MockMvcRequestBuilders.get("/worker/queryPageWorkers?page=" + 1 + "&pageSize=" + 10).contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("分页查询员工信息:" + result);
    }

    /**
     * 删除单个员工
     *
     * @throws Exception 异常
     */
    @Test
    public void testDeleteWorker() throws Exception {
        String result =
                mockMvc.perform(MockMvcRequestBuilders.get("/worker/deleteWorker?id=" + 1).contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse().getContentAsString();
        System.out.println("删除单个员工:" + result);
    }


}
