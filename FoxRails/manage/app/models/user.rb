class User < ActiveRecord::Base
	require 'digest/sha2'
	
	validates :user,:presence=>true,:uniqueness=>true
	validates :pswd,:confirmation=>true
	attr_accessor :pswd_confirmation
	attr_reader :pswd

	validate :password_must_be_present

	def User.encrypt_password(pswd,salt)
		Digest::SHA2.hexdigest(pswd+"wibble"+salt)
	end

	def pswd=(pswd)
		@pswd=pswd
		if pswd.present?
			generate_salt
			self.password=self.class.encrypt_password(pswd,salt)
		end
	end

	def User.authenticate(user,pswd)
		if user=find_by_user(user)
			if user.password==encrypt_password(pswd,user.salt)
				user
			end
		end
	end
	private 
	def generate_salt
		self.salt=self.object_id.to_s+rand.to_s
	end
	def password_must_be_present
		errors.add(:pswd,"missing password") unless password.present?
	end
end
