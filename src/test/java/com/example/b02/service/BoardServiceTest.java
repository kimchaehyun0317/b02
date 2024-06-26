package com.example.b02.service;


import com.example.b02.dto.BoardDTO;
import com.example.b02.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

    @Autowired
    BoardService boardService;

    @Test
    public void register(){
        BoardDTO boardDTO = BoardDTO.builder()
                .title("제목-1")
                .content("내용-1")
                .writer("작성자-1")
                .build();

        Long bno = boardService.register(boardDTO);

        log.info(bno);
    }

    @Test
    public void readTest(){

        BoardDTO boardDTO = boardService.read(250L);

        log.info(boardDTO);

    }

    @Test
    public void modifytest(){
        boardService.modify(BoardDTO.builder()
                        .bno(250L).title("서비스에서 수정").content("수정한 내용")
                .build());

        log.info(boardService.read(250L));
    }

    @Test
    public void deltest(){

        boardService.remove(205L);
    }

    @Test
    public void testlist(){

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("tcw")
                .keyword("53")
                .page(1)
                .build();
        log.info(boardService.list(pageRequestDTO).getTotal());
    }

}
