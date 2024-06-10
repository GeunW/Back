package edu.pnu.service;

import edu.pnu.dto.PageRequestDTO;
import edu.pnu.dto.PageResponseDTO;
import edu.pnu.dto.TodoDTO;

public interface TodoService {
    Long register(TodoDTO todoDTO);    
    TodoDTO get(Long tno);
    void modify(TodoDTO todoDTO);
    void remove(Long tno);
    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);
}
// 4-1. 등록 기능은 반환값으로(register)
// 7.조회 기능 구현(get)
// 8. 수정, 삭제 (modify,remove)
// 10. Paging 구현