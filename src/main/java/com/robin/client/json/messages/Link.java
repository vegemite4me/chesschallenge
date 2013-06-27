package com.robin.client.json.messages;

import org.apache.commons.lang3.builder.ToStringBuilder;

public final class Link {
    private final String Rel;
    private final String HRef;
    private final String Method;

    public Link(String rel, String HRef, String method) {
        this.Rel = rel;
        this.HRef = HRef;
        this.Method = method;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getRel() {
        return Rel;
    }

    public String getHRef() {
        return HRef;
    }

    public String getMethod() {
        return Method;
    }

}
