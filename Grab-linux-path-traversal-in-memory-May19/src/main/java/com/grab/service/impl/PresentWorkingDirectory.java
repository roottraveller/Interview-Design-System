package com.grab.service.impl;

import com.grab.exception.ApplicationException;
import com.grab.repository.Cache;
import com.grab.repository.impl.InMemoryCache;
import com.grab.service.Command;

public class PresentWorkingDirectory implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();

    @Override
    public void execute(String arg) throws ApplicationException {
        String pwdStr = (String) CACHE.get("pwdStr");
        System.out.println("PATH:\t" + pwdStr);
    }

}
