package edu.pnu.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.pnu.domain.Todo;
import edu.pnu.dto.PageRequestDTO;
import edu.pnu.dto.PageResponseDTO;
import edu.pnu.dto.TodoDTO;
import edu.pnu.repository.TodoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImple implements TodoService{
    private final ModelMapper modelMapper;
    private final TodoRepo todoRepo;

    @Override
    public Long register(TodoDTO todoDTO) {
        log.info("......................");
        Todo todo = modelMapper.map(todoDTO, Todo.class);
        Todo saveTodo = todoRepo.save(todo);
        return saveTodo.getTno();
    }

    @Override
    public TodoDTO get(Long tno) {
        Optional<Todo> result = todoRepo.findById(tno);
        Todo todo = result.orElseThrow();
        TodoDTO dto = modelMapper.map(todo, TodoDTO.class);
        return dto;
    }

    @Override
    public void modify(TodoDTO todoDTO) {
        Optional<Todo> result = todoRepo.findById(todoDTO.getTno());//조회
        
        Todo todo = result.orElseThrow();
        todo.changeTitle(todoDTO.getTitle());
        todo.changeDueDate(todoDTO.getDueDate());
        todo.changeComplete(todoDTO.isComplete());

        todoRepo.save(todo);
    }

    @Override
    public void remove(Long tno) {
        todoRepo.deleteById(tno);
        
    }

@Override
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() - 1, pageRequestDTO.getSize(), Sort.by("tno").descending());
        
        Page<Todo> result = todoRepo.findAll(pageable);
        List<TodoDTO> dtoList = result.getContent().stream()
            .map(todo -> modelMapper.map(todo, TodoDTO.class))
            .collect(Collectors.toList());
        
        long totalCount = result.getTotalElements();

        PageResponseDTO<TodoDTO> responseDTO = PageResponseDTO.<TodoDTO>withAll()
            .dtoList(dtoList)
            .pageRequestDTO(pageRequestDTO)
            .totalCount(totalCount)
            .build();

        return responseDTO;
    }

}
// 4-2.인터페이스 내용 없음
// 6. 등록 기능 구현
// 7. 조회기능 구현(get)
// 8. 수정, 삭제 (modify,remove)
// 10. Paging 구현