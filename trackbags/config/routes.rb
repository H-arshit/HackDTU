Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  post '/pnr/check_in'
  post '/pnr/match_status_true'
  post '/pnr/match_status_false'
  post '/pnr/unclaimed'
  post '/pnr/search_for_lost_bag'
end


# http://192.168.43.182:3000/pnr/match_status_true
