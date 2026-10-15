package com.PhamKornbluhGroup.utilities.MybatisTypeHandlers;

import com.PhamKornbluhGroup.DTO.FrameType;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FrameTypeTypeHandler<E extends FrameType> extends EnumTypeHandler<FrameType> {
    public FrameTypeTypeHandler(Class<FrameType> type) {
        super(type);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, FrameType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public FrameType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return FrameType.fromFrameType(rs.getString(columnName));
    }

    @Override
    public FrameType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return FrameType.fromFrameType(rs.getString(columnIndex));
    }

    @Override
    public FrameType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return FrameType.fromFrameType(cs.getString(columnIndex));
    }

    private FrameType stringToEnum(String string) throws SQLException {
        FrameType frameType = switch (string) {
            case "Normal frame" -> FrameType.ZERO;
            case "Magic frame" -> FrameType.ONE;
            case "Rare frame" -> FrameType.TWO;
            case "Unique frame" -> FrameType.THREE;
            case "Gem frame" -> FrameType.FOUR;
            case "Currency frame" -> FrameType.FIVE;
            case "Divination Card frame" -> FrameType.SIX;
            case "Quest frame" -> FrameType.SEVEN;
            case "Prophecy frame (legacy)" -> FrameType.EIGHT;
            case "Foil frame" -> FrameType.NINE;
            case "Supporter Foil frame" -> FrameType.TEN;
            case "Necropolis frame" -> FrameType.ELEVEN;

            default -> throw new SQLException("Failure in stringToEnum method of FrameTypeTypeHandler");
        };
        return frameType;
    }
}