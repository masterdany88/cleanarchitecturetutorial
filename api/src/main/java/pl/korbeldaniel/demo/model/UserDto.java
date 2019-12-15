package pl.korbeldaniel.demo.model;

import java.util.Objects;

public class UserDto {
    private Long id;
    private String name;

    public UserDto() {
        // jackson serialization
    }
    public UserDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) &&
                Objects.equals(name, userDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
