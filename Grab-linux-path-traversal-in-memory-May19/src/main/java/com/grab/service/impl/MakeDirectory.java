package com.grab.service.impl;

import com.grab.exception.ApplicationException;
import com.grab.exception.DirectoryAlreadyExistsException;
import com.grab.model.Directory;
import com.grab.repository.Cache;
import com.grab.repository.impl.InMemoryCache;
import com.grab.service.Command;

public class MakeDirectory implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();

    @Override
    public void execute(String arg) throws ApplicationException {
        Directory pwd = (Directory) CACHE.get("pwd");
        if (pwd.getChildren().get(arg) != null) {
            throw new DirectoryAlreadyExistsException();
        } else {
            Directory newDir = new Directory(arg, pwd);
            pwd.getChildren().put(arg, newDir);
            CACHE.put("pwd", pwd, -1);
            CACHE.put("pwdStr", pwd.getPWD(), -1);
            System.out.println("SUCC: CREATED");
        }
    }

}
