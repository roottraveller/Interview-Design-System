package com.grab.service;


import com.grab.exception.ApplicationException;

public interface Command {

    void execute(String arg) throws ApplicationException;
}
