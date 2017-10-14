class PnrController < ApplicationController

  def check_in

    @pnr=params["pnr"]
    @baggage_count=params["baggage_count"]
    if userdetails = UserDetail.find_by(pnr: @pnr)
      userdetails.baggage_count=@baggage_count
      userdetails.save

      render json: userdetails.to_json
    else
      data={
        message: "sorry pls enter a valid pnr"
      }
      render json: data
    end

  end


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
    @location=params['location']
    @baggage_pnr = params["baggage_pnr"]
    unclaimed=Unclaimed.where(baggage_pnr: @baggage_pnr).first_or_initialize
    unclaimed.location=@location
    unclaimed.save!
    data={
      message: 'added to unclaimed bags'
    }
    render json: data

  end
  def search_for_lost_bag

    @pass_pnr=params['baggage_pnr']
    if UserDetail.find_by(pnr: @pass_pnr)

      if MatchedStatusTrue.find_by(pnr: @pass_pnr)
        data={
          message: "your bag is found!"
        }
      else
        if MatchedStatusFalse.find_by(baggage_pnr: @pass_pnr)
          location=MatchedStatusFalse.find_by(baggage_pnr: @pass_pnr).pass_pnr
          location=UserDetail.find_by(pnr: location).arrival_dest
          data={
            message:"we found your bag at" +location
          }

        elsif Unclaimed.find_by(baggage_pnr: @pass_pnr) !=nil
          location=Unclaimed.find_by(baggage_pnr: @pass_pnr).location
          data={
            message: "We found your baggage. It is sitting unclaimed at " +location
          }
        else

          data={
            message: "Sorry, we cant find ur bag right now. But we will inform you once we do"
          }
        end
      end
    else
        data={
          message: "that is an invalid pnr, please enter a valid pnr"
        }
    end

    render json: data

  end






end
