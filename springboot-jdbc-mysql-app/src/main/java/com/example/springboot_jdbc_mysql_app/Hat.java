package com.example.springboot_jdbc_mysql_app;

public class Hat {
    private long id;
    private String hatname;

    /*
     * no special constructors are needed for database communication; this is just
     * used in RowMapper
     */
    public Hat(long id, String name) {
	this.id = id;
	this.hatname = name;
    }

    /* no special getters or setters are needed for database communication */
    public long getId() {
	return id;
    }

    public String getHatname() {
	return hatname;
    }

}
