package board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.entity.BoardEntity;

public interface JpaBoardService {

	List<BoardEntity> selectBoardList();

	void saveBoard(BoardEntity boardEntity, MultipartHttpServletRequest mr);

}
