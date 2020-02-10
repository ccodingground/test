package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.entity.BoardEntity;
import board.repository.JpaBoardRepository;

@Service
public class JpaBoardServiceImpl implements JpaBoardService{
	
	@Autowired
	JpaBoardRepository jpaBoardRepository;

	@Override
	public List<BoardEntity> selectBoardList() {
		
		return jpaBoardRepository.findAllByOrderByBoardNoDesc();
	}

	@Override
	public void saveBoard(BoardEntity boardEntity, MultipartHttpServletRequest mr) {
		//board테이블 데이터입력
		
		jpaBoardRepository.save(boardEntity);
		
	}

}
