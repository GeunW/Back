package edu.pnu.controller;

import org.springframework.web.bind.annotation.RestController;

import edu.pnu.dto.PageRequestDTO;
import edu.pnu.dto.PageResponseDTO;
import edu.pnu.dto.TodoDTO;
import edu.pnu.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService service;

    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable(name ="tno")Long tno) {
        return service.get(tno);
    }

    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
        log.info(pageRequestDTO);
        return service.list(pageRequestDTO);
    }
    
    
}
// 12. web get