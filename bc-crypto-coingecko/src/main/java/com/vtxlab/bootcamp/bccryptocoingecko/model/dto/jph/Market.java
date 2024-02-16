package com.vtxlab.bootcamp.bccryptocoingecko.model.dto.jph;

import java.sql.Time;

import lombok.Getter;




public class Market {

  private int id;
  private String symbol;
  private String name;
  private String image;
  private long current_price;
  private long market_cap;
  private long market_cap_rank;
  private long fully_diluted_valuation;
  private long total_volume;
  private long high_24h;
  private long low_24h;
  private double price_change_24h;
  private double price_change_percentage_24h;
  private double market_cap_change_24h;
  private double market_cap_change_percentage_24h;
  private long circulating_supply;
  private long total_supply;
  private long max_supply;
  private long ath;
  private double ath_change_percentage;
  private Time ath_dat;
  private double atl;
  private double atl_change_percentage;
  private Time atl_date;

  @Getter
  public static class roi{
    private 
  }

  private Time last_updated;
}
