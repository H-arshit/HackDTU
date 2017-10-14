class AddSeatToUserDetail < ActiveRecord::Migration[5.1]
  def change
    add_column :user_details, :seat_no, :string
  end
end
