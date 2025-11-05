package com.PhamKornbluhGroup.utilities.MybatisTypeHandlers;

import com.PhamKornbluhGroup.DTO.DisplayMode;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DisplayModeTypeHandler<E extends DisplayMode> extends EnumTypeHandler<DisplayMode> {
    public DisplayModeTypeHandler(Class<DisplayMode> type) {
        super(type);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DisplayMode parameter, JdbcType jdbcType) throws SQLException {
        super.setNonNullParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public DisplayMode getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String DisplayModeAsString = rs.getString(columnName);
        DisplayMode displayMode = this.stringToEnum(DisplayModeAsString);

        return displayMode;
    }

    @Override
    public DisplayMode getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String DisplayModeAsString = rs.getString(columnIndex);
        DisplayMode displayMode = this.stringToEnum(DisplayModeAsString);

        return displayMode;
    }

    @Override
    public DisplayMode getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String DisplayModeAsString = cs.getString(columnIndex);
        DisplayMode displayMode = this.stringToEnum(DisplayModeAsString);

        return displayMode;
    }

    private DisplayMode stringToEnum(String string) throws SQLException {
        DisplayMode displayMode = switch (string) {
            case "Name should be followed by values" -> DisplayMode.ONE;
            case "Values should be followed by name" -> DisplayMode.TWO;
            case "Progress bar" -> DisplayMode.THREE;
            case "Values should be inserted into the string by index" -> DisplayMode.FOUR;
            case "Separator" -> DisplayMode.FIVE;

            default -> throw new SQLException("Failure in stringToEnum method of DisplayModeTypeHandler");
        };
        return displayMode;
    }
}