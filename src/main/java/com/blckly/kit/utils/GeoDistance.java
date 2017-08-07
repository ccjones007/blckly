package com.blckly.kit.utils;

public class GeoDistance {
  public String name;
  public String cluster_name;
  public String cluster_id;
  public Version version;
  public String tagline;

  public class Version {
    public String number;
    public String build_hash;
    public String build_date;
    public boolean build_snapshot ;
    public String lucene_version;
  }

  public String toString() {
    return new String("name : " + name + "  tagline : " + tagline);
  }
}
