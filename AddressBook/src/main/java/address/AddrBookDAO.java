package address;

import java.util.ArrayList;

public class AddrBookDAO {
	
	private ArrayList<AddrBook> addrList = new ArrayList<>();
	
	//주소 추가
	public void add(AddrBook addrBook) {
		addrList.add(addrBook);
	}
	
	//주소 목록
	public ArrayList<AddrBook> getList(){
		return addrList;
	}
	
	//주소 상세 보기
	public AddrBook getAddrBook(String username) {
		AddrBook addrBook = null;
		
		for(int i=0; i<addrList.size(); i++) { //리스트를 순회하면서
			//이전에 저장된 이름을 가져와서
			String dbUsername = addrList.get(i).getUsername();
			if(dbUsername.equals(dbUsername)) { //외부 입력된 이름과 일치하면
				addrBook = addrList.get(i); //주소를 저장함
				break;
			}
		}
		return addrBook;  //주소 반환
	}
	
	//주소 삭제
	public void deleteAddrBook(String username) {
		AddrBook addrBook = null;
		
		for(int i=0; i<addrList.size(); i++) { 
			String dbUsername = addrList.get(i).getUsername();
			if(dbUsername.equals(dbUsername)) {
				addrBook = addrList.get(i); 
				addrList.remove(addrBook);  //주소 삭제
				break;
			}
		}
	}
}
