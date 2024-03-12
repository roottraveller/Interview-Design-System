package com.grab.service.impl;

import com.grab.exception.ApplicationException;
import com.grab.exception.DirectoryNotFoundException;
import com.grab.model.Directory;
import com.grab.repository.Cache;
import com.grab.repository.impl.InMemoryCache;
import com.grab.service.Command;

public class RemoveDirectory implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();

    @Override
    public void execute(String arg) throws ApplicationException {
        Directory pwd = (Directory) CACHE.get("pwd");
        if (pwd.getChildren().get(arg) != null) {
            pwd.getChildren().remove(arg);
            CACHE.put("pwd", pwd, -1);
            CACHE.put("pwdStr", pwd.getPWD(), -1);
        } else {
            throw new DirectoryNotFoundException();
        }

    }
}
