package net.noncore.fdx.domains.services;

public interface Service<P, R> {
    R execute(P param);
}
