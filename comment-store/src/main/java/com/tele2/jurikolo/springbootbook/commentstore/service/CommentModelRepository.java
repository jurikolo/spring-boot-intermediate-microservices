package com.tele2.jurikolo.springbootbook.commentstore.service;

import java.util.List;

import com.tele2.jurikolo.springbootbook.model.CommentModel;
import org.springframework.data.repository.CrudRepository;

public interface CommentModelRepository extends CrudRepository<CommentModel, String>{

//    @Query("select a from CommentModel a where a.pageId = ?1")
    List<CommentModel> findByPageId(String pageId);
    
    List<CommentModel> findByPageIdAndSpamIsTrue(String pageId);
}
