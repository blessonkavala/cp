package com.svcet.cashportal.repository.acl;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.MenuItems;

public interface MenuItemRepository extends OrientObjectRepository<MenuItems> {
	@Query("select from MenuItems where @rid = ?")
	MenuItems findByRid(String rid);
}
