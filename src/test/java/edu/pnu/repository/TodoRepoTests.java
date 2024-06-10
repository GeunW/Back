package edu.pnu.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Todo;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepoTests {
    @Autowired
    private TodoRepo todoRepo;
    // @Test
    // public void test1(){
    //     log.info("------------");
    //     log.info(todoRepo);
    // }
    @Test
    public void testInsert(){
        for(int i=1; i<=100; i++){
            Todo todo = Todo.builder()
            .title("Title..."+i)
            .dueDate(LocalDate.of(2024,06,10))
            .writer("user00")
            .build();

            todoRepo.save(todo);
        }
    }
    @Test
    public void testRead(){
        Long tno = 33L;
        java.util.Optional<Todo> result = todoRepo.findById(tno);
        Todo todo = result.orElseThrow();
        log.info(todo);
    }

    @Test
    public void testModify(){
        Long tno = 33L;
        Optional<Todo> result = todoRepo.findById(tno);
        Todo todo = result.orElseThrow();
        todo.changeTitle("Modified...33");
        todo.changeComplete(true);
        todo.changeDueDate(LocalDate.of(2024, 06, 11));
        
        todoRepo.save(todo);
    }

    @Test
    public void testDelete(){
        Long tno = 1L;
        todoRepo.deleteById(tno);
    }

    @Test
    public void testPaging(){
        Pageable pageable = PageRequest.of(0,10,Sort.by("tno").descending());
        Page<Todo> result = todoRepo.findAll(pageable);
        log.info(result.getTotalElements());
        result.getContent().stream().forEach(todo -> log.info(todo));
    }
}
// test 실행.. 데이터 넣기, 읽기, 수정, 삭제, 페이징
