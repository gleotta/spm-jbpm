package com.cuyum.jbpm;

import java.util.ArrayList;
import java.util.List;

import org.jbpm.task.service.UserGroupCallback;

public class JbpmUserGroupCallback implements UserGroupCallback {

	@Override
	public boolean existsGroup(String group) {

		return true;
	}

	@Override
	public boolean existsUser(String user) {
		
		return true;
	}

	@Override
	public List<String> getGroupsForUser(String user, List<String> groupIds,
			List<String> allExistingGroupIds) {
//		System.out.println("SPMUserGroupCallback#getGroupsForUser:" + user);
//		System.out.println("groupIds:" + groupIds);
//		System.out.println("allExistingGroupIds:" + allExistingGroupIds);
		

		if (groupIds != null) {
			List<String> retList = new ArrayList<String>(groupIds);
			return retList;
		}
		return new ArrayList<String>();

	}

}
