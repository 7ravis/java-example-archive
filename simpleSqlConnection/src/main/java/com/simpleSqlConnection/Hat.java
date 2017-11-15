package com.simpleSqlConnection;

public class Hat {
  private long id;
  private boolean idSet = false;
  private String name;
  private String color;
  private int size;

  public Hat(String name, String color, int size) {
    this.name = name;
    this.color = color;
    this.size = size;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    if (idSet) {
      throw new IllegalStateException("Error: a hat id can only be set once.");
    }
    this.id = id;
    idSet = true;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    result = prime * result + (int) (id ^ (id >>> 32));
    result = prime * result + (idSet ? 1231 : 1237);
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + size;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Hat other = (Hat) obj;
    if (color == null) {
      if (other.color != null)
        return false;
    } else if (!color.equals(other.color))
      return false;
    if (id != other.id)
      return false;
    if (idSet != other.idSet)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (size != other.size)
      return false;
    return true;
  }

}
