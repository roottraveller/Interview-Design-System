package com.grab.service.impl;

import com.grab.exception.ApplicationException;
import com.grab.exception.InvalidInputException;
import com.grab.model.Directory;
import com.grab.repository.Cache;
import com.grab.repository.impl.InMemoryCache;
import com.grab.service.Command;

public class Session implements Command {

    private final static Cache CACHE = InMemoryCache.getInstance();

    private void clearSession() {
        CACHE.clear();
        CACHE.put("pwd", Directory.ROOT, -1);
        CACHE.put("pwdStr", Directory.ROOT.getPWD(), -1);
    }


    @Override
    public void execute(String arg) throws ApplicationException {
        switch (arg) {
            case "clear": clearSession();break;
            case "exit": System.exit(0);
            default:
                throw new InvalidInputException();
        }
    }
}
