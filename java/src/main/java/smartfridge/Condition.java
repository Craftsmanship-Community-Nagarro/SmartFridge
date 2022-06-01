// Copyright (c) 2008-2022  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package smartfridge;

public enum Condition {
    SEALED("SEALED"),
    EXPIRED("EXPIRED"),
    OPENED("OPENED");

    private String status;

    Condition(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
