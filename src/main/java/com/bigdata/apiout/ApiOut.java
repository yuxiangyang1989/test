package com.bigdata.apiout;

import com.bigdata.enums.ResponseCode;
import com.bigdata.framework.common.utils.NumberUtils;
import com.bigdata.framework.common.utils.StringUtils;
import com.github.pagehelper.Page;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author yang
 * @ClassName: ApiOut
 * @Description:接口统一返回
 * @date 2018-05-22
 * @version:1.0.0
 */
@Data
public class ApiOut<T> implements Serializable{
    private Integer code;
    private String msg;
    private String state;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String debugMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long elapsedTime;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Pagination pagination;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static final class Builder<T> {
        private boolean debug = false;
        private ResponseCode responseCode = ResponseCode.SUCCESS;
        private Integer code;
        private String message;
        private String debugMessage;
        private Long elapsedTime;
        private Long startTime;
        private Integer totalRow;
        private Integer pageSize;
        private Integer pageIndex;
        private T data;

        public Builder() {
            if (this.debug) {
                startTime = System.currentTimeMillis();
            }
        }

        public Builder(boolean debug) {
            this.debug = debug;
            if (this.debug) {
                startTime = System.currentTimeMillis();
            }
        }

        public Builder<T> code(Integer code) {
            this.code = code;
            return this;
        }

        public Builder<T> code(ResponseCode responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> debugMessage(String debugMessage) {
            this.debugMessage = debugMessage;
            return this;
        }

        public Builder<T> elapsedTime(long elapsedTime) {
            if (elapsedTime > 0) {
                this.elapsedTime = elapsedTime;
            }
            return this;
        }

        public Builder<T> totalRow(int totalRow) {
            if (totalRow > 0) {
                this.totalRow = totalRow;
            }
            return this;
        }

        public Builder<T> pageSize(int pageSize) {
            if (pageSize > 0) {
                this.pageSize = pageSize;
            }
            return this;
        }

        public Builder<T> pageIndex(int pageIndex) {
            if (pageIndex > 0) {
                this.pageIndex = pageIndex;
            }
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiOut<T> build() {
            if (data instanceof Page) {
                Page page = (Page) data;
                this.totalRow = (int) page.getTotal();
                this.pageSize = page.getPageSize();
                this.pageIndex = page.getPageNum();
            }
            return new ApiOut<T>(this);
        }
    }
    private ApiOut(Builder<T> builder) {
        this.code = Optional.ofNullable(builder.code).orElse(builder.responseCode.code());
        this.state = StringUtils.camelToUnderline(Optional.of(builder.responseCode).orElse(ResponseCode.SUCCESS).name()).toUpperCase();
        this.msg = StringUtils.isBlank(builder.message) ? builder.responseCode.desc() : builder.message;
        this.debugMessage = StringUtils.isBlank(builder.debugMessage) ? null : builder.debugMessage;

        if (null != builder.elapsedTime) {
            this.elapsedTime = builder.elapsedTime;
        } else if (builder.debug) {
            this.elapsedTime = System.currentTimeMillis() - builder.startTime;
        }

        if (NumberUtils.isPositive(builder.totalRow)
                || NumberUtils.isPositive(builder.pageSize)
                || NumberUtils.isPositive(builder.pageIndex)) {
            this.pagination = new Pagination(builder.totalRow, builder.pageSize, builder.pageIndex);
        }
        this.data = builder.data;
    }
}
