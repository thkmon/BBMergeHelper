package com.bb.patch.file.data;

import java.util.ArrayList;
import java.util.HashMap;


public class UniqueStringList extends ArrayList<String> {
	
	
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	
	public boolean add(String str) {
		if (str == null || str.trim().length() == 0) {
			return false;
		} else {
			str = str.trim();
		}
		
		if (map.get(str) == null) {
			map.put(str, 1);
			super.add(str);
			return true;
		}
		
		return false;
	}
	
	public boolean add(ArrayList<String> strList) {
		if (strList == null || strList.size() == 0) {
			return false;
		}
		
		boolean bResult = false;
		
		String oneStr = "";
		int count = strList.size();
		for (int i=0; i<count; i++) {
			oneStr = strList.get(i);
			if (oneStr != null && oneStr.length() > 0) {
				// 한 개라도 성공이면 성공
				boolean bSuccess = add(oneStr);
				if (bSuccess) {
					bResult = true;
				}
			}
		}
		
		return bResult;
	}
}