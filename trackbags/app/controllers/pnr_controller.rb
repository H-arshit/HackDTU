class PnrController < ApplicationController

  def check_in

    @pnr=params["pnr"]
    @baggage_count=params["baggage_count"]
    userdetails = UserDetail.find_by(pnr: @pnr)
    userdetails.baggage_count=@baggage_count
    userdetails.save

    render json: userdetails.to_json

  end
  # def baggage_count
  #   @pnr=params["pnr"]
  #   userdetails = UserDetail.find_by(pnr: @pnr)
  #   userdetails.baggage_count=params["baggage_count"]
  #   if userdetails.save
  #     data={
  #       message:"successfully updated bag count"
  #     }
  #   else
  #     data={
  #       message:"some error occured, please try again later"
  #     }
  #   end
  #   render json: data
  # end


  def match_status_true

    @baggage_pnr = params["baggage_pnr"]
    MatchedStatusTrue.create(pnr: @baggage_pnr)
    match_status_false=MatchedStatusFalse.find_by(baggage_pnr: @baggage_pnr)
    data={
      message:"successfully saved bag status"
    }
    if match_status_false
      match_status_false.destroy
      data={
        message:"successfully updated baggage status"
      }
    end
    unclaimed=Unclaimed.find_by(baggage_pnr: @baggage_pnr)
    if unclaimed
      unclaimed.destroy
      data={
        message:"successfully updated baggage status"
      }
    end


    render json: data

  end

  def match_status_false
    @baggage_pnr = params["baggage_pnr"]
    @pass_pnr = params["pass_pnr"]
    MatchedStatusFalse.create(baggage_pnr: @baggage_pnr, pass_pnr: @pass_pnr)

    data={
      message: 'sorry! this bag does not belong to you'
    }
    render json: data
  end



  def unclaimed
    @baggage_pnr = params["baggage_pnr"]
    Unclaimed.create(baggage_pnr: @baggage_pnr)
    data={
      message: 'added to unclaimed bags'
    }
    render json: data

  end






end
