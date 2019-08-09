import { SimpleMessage } from '@shared/components/simple-messages/simple-message';
import { Ordenacao } from '@shared/components/paginacao/ordenacao';

export class CustomPageResource<T> {

  content: Array<T>;
  contentSize: number;
  hasContent: boolean;
  hasNext: boolean;
  hasPrevious: boolean;
  isFirst: boolean;
  isLast: boolean;
  messages: Array<SimpleMessage>;
  pageNext: number;
  pageNumber: number;
  pagePrevious: number;
  pageSize: number;
  parameters: any;
  totalElements: number;
  totalPages: number;
  sort: Ordenacao;
}




