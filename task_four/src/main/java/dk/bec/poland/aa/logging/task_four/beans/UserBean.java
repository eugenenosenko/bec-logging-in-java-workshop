package dk.bec.poland.aa.logging.task_four.beans;

import java.util.Objects;

// Bean is a java class that is designed only to hold information and nothing else
// Like the class below. it's only purpose is to hold name and lastName
public final class UserBean {
  private String name;
  private String lastName;

  public UserBean() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "User{" + "name='" + name + '\'' + ", lastName='" + lastName + '\'' + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserBean userBean = (UserBean) o;
    return Objects.equals(name, userBean.name) && Objects.equals(lastName, userBean.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName);
  }
}
