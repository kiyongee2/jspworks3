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
}
