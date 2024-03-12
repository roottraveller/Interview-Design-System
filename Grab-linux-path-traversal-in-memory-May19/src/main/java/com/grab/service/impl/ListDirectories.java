package com.grab.service.impl;

import com.grab.exception.ApplicationException;
import com.grab.model.Directory;
import com.grab.repository.Cache;
import com.grab.repository.impl.InMemoryCache;
import com.grab.service.Command;

public class ListDirectories implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();


    @Override
    public void execute(String arg) throws ApplicationException {
        Directory pwd = (Directory) CACHE.get("pwd");
        System.out.println("DIRS:\t"+pwd.listChildDirNames());
    }
}
