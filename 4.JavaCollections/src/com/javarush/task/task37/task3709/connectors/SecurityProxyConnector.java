package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {

    private SimpleConnector connector;
    private SecurityChecker securityChecker = new SecurityCheckerImpl();

    public SecurityProxyConnector(String resourceString) {
        connector = new SimpleConnector(resourceString);
    }

    @Override
    public void connect() {
        if (securityChecker.performSecurityCheck())
            connector.connect();
    }
}
