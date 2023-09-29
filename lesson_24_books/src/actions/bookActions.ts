// Действие для добавления книги
export const addBook = (book: any) => {
    return {
      type: 'ADD_BOOK',
      payload: book,
    };
  };
  
  // Действие для удаления книги
  export const removeBook = (bookId: any) => {
    return {
      type: 'REMOVE_BOOK',
      payload: bookId,
    };
  };
  