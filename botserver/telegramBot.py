import telebot
from telebot import types
from services import getResults, deleteAllResults, getFilters, postFilter, deleteAllFilters

TOKEN = " "
bot = telebot.TeleBot(TOKEN)

@bot.message_handler(regexp='start')
def buttons(message):
    markup = types.ReplyKeyboardMarkup(row_width=2)
    itembtn1 = types.KeyboardButton('Results')
    itembtn2 = types.KeyboardButton('Clear')
    itembtn3 = types.KeyboardButton('Filters')
    itembtn4 = types.KeyboardButton('Delete')
    itembtn5 = types.KeyboardButton('Mazda')
    itembtn6 = types.KeyboardButton('Audi')
    itembtn7 = types.KeyboardButton('Toyota')
    itembtn8 = types.KeyboardButton('Ваз')
    itembtn9 = types.KeyboardButton('Ford')
    itembtn10 = types.KeyboardButton('Kia')
    itembtn11 = types.KeyboardButton('Skoda')
    itembtn12 = types.KeyboardButton('Volkswagen')
    itembtn13 = types.KeyboardButton('Renault')
    itembtn14 = types.KeyboardButton('Opel')
    itembtn15 = types.KeyboardButton('BMW')
    itembtn16 = types.KeyboardButton('Peugeot')
    markup.row(itembtn5)
    markup.row(itembtn6)
    markup.row(itembtn7)
    markup.row(itembtn8)
    markup.row(itembtn9)
    markup.row(itembtn10)
    markup.row(itembtn11)
    markup.row(itembtn12)
    markup.row(itembtn13)
    markup.row(itembtn14)
    markup.row(itembtn15)
    markup.row(itembtn16)

    markup.row(itembtn1, itembtn2)
    markup.row(itembtn3, itembtn4)
    bot.send_message(message.chat.id, "Choose the model:", reply_markup=markup)
	
@bot.message_handler(regexp='Results')
def get_results(message):
    id = message.from_user.id
    data = getResults(id)
    bot.send_message(message.chat.id, "Here's your results:")
    for i in data:
        bot.send_message(message.chat.id, i['url'])

@bot.message_handler(regexp='Filters')
def get_results(message):
    id = message.from_user.id
    data = getFilters(id)
    bot.send_message(message.chat.id, "Here's your filters:")
    for i in data:
        bot.send_message(message.chat.id, i['searchString'])

@bot.message_handler(regexp='Clear')
def clear_results(message):
    id = message.from_user.id
    clear_res = deleteAllResults(id)
    bot.send_message(message.chat.id, clear_res)

@bot.message_handler(regexp='Delete')
def delete_filters(message):
    id = message.from_user.id
    del_res = deleteAllFilters(id)
    bot.send_message(message.chat.id, del_res)

@bot.message_handler(regexp='Mazda')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Mazda",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Audi')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Audi",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Kia')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Kia",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Toyota')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Toyota",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Ваз')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Ваз",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Ford')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Ford",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Skoda')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Skoda",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Volkswagen')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Volkswagen",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Renault')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Renault",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Opel')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Opel",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='BMW')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "BMW",)
    print(type(id))
    bot.reply_to(message, data)

@bot.message_handler(regexp='Peugeot')
def post_filter(message):
    id = message.from_user.id
    data = postFilter(id, "Peugeot",)
    print(type(id))
    bot.reply_to(message, data)
    
bot.infinity_polling()