package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceimpl implements MemberService {
	@Autowired
	MemberDAO dao;

	@Override
	public List<MemberDTO> memberlist() {
		// dao.xxxx()를 실행해주면됨.
		return dao.memberlist();
	}

	@Override
	public int membercount() {
		return dao.membercount();
	}


	@Override
	public MemberDTO onemember(String id) {
		return dao.onemember(id);
	}


	@Override
	public List<MemberDTO> pageinglist(int[] limit) {
		return dao.pageinglist(limit);
	}


	@Override
	public int insertmember(MemberDTO dto) {
		MemberDTO resultdto = dao.onemember(dto.getId());
		if (resultdto == null) {
			return dao.insertmember(dto);			
		}
		return 0;
	}


	@Override
	public int updatemember(MemberDTO dto) {
		MemberDTO resultdto = dao.onemember(dto.getId());
		if (resultdto != null) {
			return dao.updatemember(dto);		
		}
		return 0;
	}

	@Override
	public int deletemember(String id) {
		MemberDTO resultdto = dao.onemember(id);
		if (resultdto != null) {
			return dao.deletemember(id);		
		}
		return 0;
	}

	@Override
	public List<MemberDTO> searchmember(HashMap map) {
		return dao.searchmember(map);
	}


	@Override
	public List<MemberDTO> addresssearch(ArrayList<String> addresslist) {
		return dao.addresssearch(addresslist);
	}


	@Override
	public List<MemberDTO> combination(MemberDTO comdto) {
		return dao.combination(comdto);
	}

	@Override
	public List<HashMap<String, String>> memberboard(String writer) {
		return dao.memberboard(writer);
	}
	
	
	
}
