package com.rs.eis.service;


import com.rs.eis.model.Prefix;

import com.rs.eis.response.DeletePrefixResponse;
import com.rs.eis.response.EditPrefixResponse;
import com.rs.eis.response.GetPrefixResponse;
import com.rs.eis.response.PrefixResponse;

public interface PrefixService {
	PrefixResponse prefix(Prefix prefix);
	EditPrefixResponse editPrefix(Prefix prefix);
	DeletePrefixResponse deletePrefix(int employeId);
	GetPrefixResponse getPrefixById(int id);

}
