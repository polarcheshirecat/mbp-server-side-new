package ru.spb.devpractices.masterbest.serverside.dto.integration;import lombok.AllArgsConstructor;import lombok.Data;import lombok.EqualsAndHashCode;import lombok.NoArgsConstructor;import java.io.Serializable;@Data@EqualsAndHashCode@AllArgsConstructor@NoArgsConstructorpublic class IntegrationOrderStatusDTO implements Serializable {    private String userId;    private String status;    private String guid;    private String comment;}