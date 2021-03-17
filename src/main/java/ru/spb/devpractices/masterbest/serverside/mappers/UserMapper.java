package ru.spb.devpractices.masterbest.serverside.mappers;import org.mapstruct.Mapper;import ru.spb.devpractices.masterbest.serverside.dto.front.UserDTO;import ru.spb.devpractices.masterbest.serverside.model.User;import ru.spb.devpractices.masterbest.serverside.model.UserRole;import ru.spb.devpractices.masterbest.serverside.model.UserStatus;@Mapper(componentModel = "spring")public interface UserMapper {    UserDTO toDto (User user);    User toEntity (UserDTO dto);    default String userStatusToString (UserStatus status){        if (status == null) return "";        return status.getDescription();    }    default UserStatus stringToUserStatus (String descr){        return UserStatus.getStatusByDescription(descr);    }    default  String userRoleToString (UserRole role){        if (role == null) return "";        return role.getDescription();    }    default  UserRole stringToUserRole (String role){        return UserRole.getRoleByDescription(role);    }}