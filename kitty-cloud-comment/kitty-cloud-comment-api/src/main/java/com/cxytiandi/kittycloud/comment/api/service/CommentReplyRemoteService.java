package com.cxytiandi.kittycloud.comment.api.service;

import com.cxytiandi.kittycloud.comment.api.fallback.CommentReplyRemoteServiceFallbackFactory;
import com.cxytiandi.kittycloud.comment.api.request.CommentReplySaveRequest;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * 评论回复RPC/REST接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@FeignClient(name = "kitty-cloud-comment-provider", contextId = "CommentReplyRemoteService", fallbackFactory = CommentReplyRemoteServiceFallbackFactory.class)
public interface CommentReplyRemoteService {

    /**
     * 保存回复
     * @param request 回复参数
     * @return 评论ID
     */
    @PostMapping("/replys")
    ResponseData<String> saveCommentReply(@RequestBody CommentReplySaveRequest request);

    /**
     * 删除回复
     * @param id 回复ID
     * @return 是否删除成功
     */
    @DeleteMapping("/replys/{id}")
    ResponseData<Boolean> removeCommentReply(@PathVariable String id);

}
