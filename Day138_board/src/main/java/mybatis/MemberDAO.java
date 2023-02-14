package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("memberdao")
public interface MemberDAO {
	//dao 매서드명과 Sql-mapping.xml의 id가 동일하면 자동 매핑
	public List<MemberDTO> memberlist();
	public int membercount();
	public MemberDTO onemember(String id);
	public List<MemberDTO> pageinglist(int[] limit);
	public int insertmember(MemberDTO dto);
	public int updatemember(MemberDTO dto);
	public int deletemember(String id);
	public List<MemberDTO> searchmember(HashMap map);
	public List<MemberDTO> addresssearch(ArrayList<String> addresslist);
	public List<MemberDTO> combination(MemberDTO comdto);
	public List<HashMap<String,String>> memberboard(String writer);
	
}
